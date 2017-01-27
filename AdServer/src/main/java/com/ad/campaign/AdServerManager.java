package com.ad.campaign;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AdServerManager {
	private Map<String, AdVO> adMap;

	public AdServerManager() {
		System.out.println("AdCampaignDAO called");
		adMap = new HashMap<String, AdVO>();
	}

	protected void removeExpiredAds() {
		System.out.println("removeExpiredAds method called...");
		if (adMap != null && !adMap.isEmpty()) {
			Iterator it = adMap.entrySet().iterator();
			System.out.println("Checking for expired Ads...");
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				AdVO adVO = (AdVO) pair.getValue();
				System.out.println(pair.getKey() + " = " + pair.getValue());
				Calendar currTime = Calendar.getInstance();
				// newCal.setTime(adVO.getCreatedTime());
				Calendar oldCal = Calendar.getInstance();
				oldCal.setTime(adVO.getCreatedTime());
				oldCal.add(Calendar.SECOND, adVO.getDuration());
				Date dt = new Date(oldCal.getTimeInMillis());
				System.out.println(dt);
				if (currTime.getTimeInMillis() >= oldCal.getTimeInMillis()) {
					System.out.println("<<<<  REMOVED EXPIRED AD (" + adVO.partner_id + ")  >>>>>");
					adMap.remove(adVO.getPartner_id());
				}

			}
		}
	}

	public void createAd(AdVO adVO) throws Exception {
		removeExpiredAds();
		if (adMap.containsKey(adVO.getPartner_id())) {
			throw new Exception("Ad is already created and live");
		}
		adMap.put(adVO.getPartner_id(), adVO);
	}

	public AdVO getAd(String partnerId) throws Exception {
		System.out.println("returning AD for " + partnerId);
		removeExpiredAds();
		AdVO ad = null;
		if (adMap != null && !adMap.isEmpty()) {
			ad = adMap.get(partnerId);
		}
		if (ad == null) {
			throw new Exception("No AD found for partner_id : " + partnerId);
		}

		return ad;

	}

	public List<AdVO> listAddAds() {
		List<AdVO> allAds = new ArrayList<AdVO>();
		allAds.addAll(adMap.values());
		System.out.println("return all Ad size " + allAds.size());
		return allAds;
	}

}
