package com.postgres_backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressCompositeKey implements Serializable {

	@Embedded
	private CompositeID userCompositeId;

	@Embedded
	private AddressCompositeID addressCompositeId;
}
