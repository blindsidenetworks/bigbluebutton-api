/*
	BigBlueButton - http://www.bigbluebutton.org

	Copyright (c) 2008-2012 by respective authors (see below). All rights reserved.

	BigBlueButton is free software; you can redistribute it and/or modify it under the
	terms of the GNU Lesser General Public License as published by the Free Software
	Foundation; either version 2 of the License, or (at your option) any later
	version.

	BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY
	WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
	PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

	You should have received a copy of the GNU Lesser General Public License along
	with BigBlueButton; if not, If not, see <http://www.gnu.org/licenses/>.

	Author: Jesus Federico <jesus@blindsidenetworks.com>
*/
package org.bigbluebutton.impl;

import java.util.Map;

public class BBBv0p8p0 extends BBBProxyImpl {

	public BBBv0p8p0(){
		super();
	}

    public BBBv0p8p0(String endpoint, String secret){
        super(endpoint, secret);
    }

    public String getCreateURL(Map<String, String> params){
        String qs;

        qs = "name=" + params.get("name");
        qs += "&meetingID=" + params.get("meetingID");
        qs += "&moderatorPW=" + params.get("moderatorPW");
        qs += "&attendeePW=" + params.get("attendeePW");
        qs += params.containsKey("welcome")? "&welcome=" + params.get("welcome"): "";
        qs += params.containsKey("logoutURL")? "&logoutURL=" + params.get("logoutURL"): "";
        qs += params.containsKey("voiceBridge")? "&voiceBridge=" + params.get("voiceBridge"): "";
        qs += params.containsKey("dialNumber")? "&dialNumber=" + params.get("dialNumber"): "";
        qs += params.containsKey("record")? "&record=" + params.get("record"): "";
        qs += params.containsKey("duration")? "&duration=" + params.get("duration"): "";
        qs += params.containsKey("meta")? "&" + params.get("meta"): "";
        qs += getCheckSumParameterForQuery(APICALL_CREATE, qs);

        return this.endpoint + API_SERVERPATH + APICALL_CREATE + "?" + qs;
    }

	public String getGetRecordingsURL(String meetingID) {
	    String qs;

	    qs = "meetingID=" + meetingID;
	    qs += getCheckSumParameterForQuery(APICALL_GETRECORDINGS, qs);

	    return this.endpoint + API_SERVERPATH + APICALL_GETRECORDINGS + "?" + qs;
	}

	public String getPublishRecordingsURL(String recordID, boolean publish) {
	    String qs;

	    qs = "recordID=" + recordID;
	    qs += "&publish=" + Boolean.valueOf(publish);
	    qs += getCheckSumParameterForQuery(APICALL_PUBLISHRECORDINGS, qs);

	    return this.endpoint + API_SERVERPATH + APICALL_PUBLISHRECORDINGS + "?" + qs;
	}

	public String getDeleteRecordingsURL(String recordID) {
	    String qs;

	    qs = "recordID=" + recordID;
	    qs += getCheckSumParameterForQuery(APICALL_DELETERECORDINGS, qs);

	    return this.endpoint + API_SERVERPATH + APICALL_DELETERECORDINGS + "?" + qs;
	}
}
