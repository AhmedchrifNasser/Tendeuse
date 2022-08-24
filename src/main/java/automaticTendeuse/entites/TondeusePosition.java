package automaticTendeuse.entites;

public class TondeusePosition {
	
	private Coordinates tondeuseCoordinates;
	private Params.Orientation tondeuseOrientation;

	public TondeusePosition(Coordinates pCoordinatesTondeuse,
							Params.Orientation pOrientationTondeuse) {
		this.tondeuseCoordinates = pCoordinatesTondeuse;
		this.tondeuseOrientation = pOrientationTondeuse;
	}

	public Params.Orientation getTondeuseOrientation() {
		return tondeuseOrientation;
	}

	public void setTondeuseOrientation(Params.Orientation pOrientationTondeuse) {
		this.tondeuseOrientation = pOrientationTondeuse;
	}

	public Coordinates getTondeuseCoordinates() {
		return tondeuseCoordinates;
	}

	public void setTondeuseCoordinates(Coordinates pCoordonneesTondeuse) {
		this.tondeuseCoordinates = pCoordonneesTondeuse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tondeuseCoordinates == null) ? 0 : tondeuseCoordinates.hashCode());
		result = prime * result + ((tondeuseOrientation == null) ? 0 : tondeuseOrientation.hashCode());
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
		TondeusePosition other = (TondeusePosition) obj;
		if (tondeuseCoordinates == null) {
			if (other.tondeuseCoordinates != null)
				return false;
			} else if (!tondeuseCoordinates.equals(other.tondeuseCoordinates))
				return false;
		if (tondeuseOrientation != other.tondeuseOrientation)
			return false;
		return true;
	}
}