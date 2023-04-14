package beast.catalog.model;

import lombok.Data;
import org.jooq.tools.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Vendor {
    private String vendorId;
    private String vendorName;
    private String adminUserIds;

    public Set<String> getAdminUsers() {
        if (StringUtils.isBlank(adminUserIds)) return Set.of();  //null blank or whitespace

        return Arrays.stream(adminUserIds.split(","))
                .collect(Collectors.toSet());
    }
}
