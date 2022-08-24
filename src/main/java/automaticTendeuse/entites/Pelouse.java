package automaticTendeuse.entites;
public class Pelouse {

	private Coordinates positionMax;
	public Pelouse(){
		
	}
	public Pelouse(Coordinates pPositionMax) {
		this.positionMax = pPositionMax;
	}

	public Coordinates getPositionMax() {
		return positionMax;
	}

	public void setPositionMax(Coordinates positionMax) {
		this.positionMax = positionMax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((positionMax == null) ? 0 : positionMax.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelouse other = (Pelouse) obj;
		if (positionMax == null) {
			if (other.positionMax != null)
				return false;
			} else if (!positionMax.equals(other.positionMax))
				return false;
		return true;
	}
}