

package org.egov.lams.common.web.contract;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * An object which holds the  Property Type Master info
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyType {

   @NotNull
  private Long id = null;

  @NotNull
  @Size(min = 2, max = 128)
  private String tenantId = null;

  @NotNull
  @Size(min = 1, max = 64)
  private String code = null;

  @NotNull
  @Size(min = 1, max = 128)
  private String name = null;

  @NotNull
  private Boolean isActive = null;
  
}

