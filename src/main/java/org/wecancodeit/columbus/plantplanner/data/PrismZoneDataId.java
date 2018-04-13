package org.wecancodeit.columbus.plantplanner.data;

import java.io.Serializable;

public class PrismZoneDataId implements Serializable {

	private static final long serialVersionUID = -7478376858524650508L;
		private String zone;
       private String trange;

       public PrismZoneDataId() {}

       public PrismZoneDataId(String zone, String trange) {
           this.zone = zone;
           this.trange = trange;
       }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trange == null) ? 0 : trange.hashCode());
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PrismZoneDataId)) {
			return false;
		}
		PrismZoneDataId other = (PrismZoneDataId) obj;
		if (trange == null) {
			if (other.trange != null) {
				return false;
			}
		} else if (!trange.equals(other.trange)) {
			return false;
		}
		if (zone == null) {
			if (other.zone != null) {
				return false;
			}
		} else if (!zone.equals(other.zone)) {
			return false;
		}
		return true;
	}

    
  }