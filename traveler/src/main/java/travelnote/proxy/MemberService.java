package travelnote.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import travelnote.dto.MembersRequest;
import travelnote.dto.MembersResponse;
import java.util.List;

@Service
public class MemberService {
    
    private final RestClient restClient;
    private final String memberServiceUrl;
    
    public MemberService(RestClient.Builder restClientBuilder,
                        @Value("${member.service.url}") String memberServiceUrl) {
        this.restClient = restClientBuilder.build();
        this.memberServiceUrl = memberServiceUrl;
    }
    
    public MembersResponse getMembersByIds(List<Long> memberIds) {
        MembersRequest request = new MembersRequest(memberIds);
        return restClient.post()
                .uri(memberServiceUrl + "/api/members")
                .body(request)
                .retrieve()
                .body(MembersResponse.class);
    }
}

