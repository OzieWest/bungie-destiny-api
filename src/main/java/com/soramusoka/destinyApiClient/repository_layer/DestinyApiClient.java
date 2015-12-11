package com.soramusoka.destinyApiClient.repository_layer;

import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummary;
import com.soramusoka.destinyApiClient.dto_layer.account_summary.AccountSummaryResponse;
import com.soramusoka.destinyApiClient.dto_layer.membership_id.MembershipId;
import com.soramusoka.destinyApiClient.dto_layer.membership_id.MembershipIdResponse;
import com.soramusoka.destinyApiClient.service_layer.IRequest;
import org.codehaus.jackson.map.ObjectMapper;

public class DestinyApiClient {
    public IRequest Request;
    private String _hostName = "http://www.bungie.net";
    private String _rootPath = "/Platform/Destiny";
    private Integer _platform = 2;
    private ObjectMapper _mapper = null;

    public DestinyApiClient(IRequest request, Integer platform) {
        this._mapper = new ObjectMapper();
        this.Request = request;
        this._platform = platform;
    }

    private String formUrl(String url) {
        return this._hostName + this._rootPath + url;
    }

    public MembershipId[] getMembershipId(String userName) throws Exception {
        String urlSearchDestinyPlayer = this.formUrl("/SearchDestinyPlayer/" + this._platform + "/" + userName);

        String data = this.Request.getUrl(urlSearchDestinyPlayer);
        MembershipIdResponse response = this._mapper.readValue(data, MembershipIdResponse.class);

        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);

        return response.Response;
    }

    public AccountSummary getAccountSummary(String membershipId) throws Exception {
        String urlAccountSummary = this.formUrl("/" + this._platform + "/Account/" + membershipId);

        String data = this.Request.getUrl(urlAccountSummary);
        AccountSummaryResponse response = this._mapper.readValue(data, AccountSummaryResponse.class);

        if (response.ErrorCode != 1) throw new Exception(response.ErrorStatus + ": " + response.Message);

        return response.Response.data;
    }
}
