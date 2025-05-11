
public class HuffmanChar implements Comparable<HuffmanChar>{
	private Character character;
	private Integer freq;
	public HuffmanChar(Character l, Integer i) {
		character = l;
		freq = i;
	}
	
	public HuffmanChar(Character l) {
		this(l,0);
	}
	
	public HuffmanChar(int i) {
		this(null,i);
	}
	
	public char getCharacter() {
		return character;
	}
	
	public int getFreqeuency() {
		return freq;
	}
	
	public void incrementFreq() {
		freq++;
	}
	
	@Override
	public int compareTo(HuffmanChar o) {
		
		
		int y = this.character.compareTo(o.character);
		int x = this.freq.compareTo(o.freq);
		
		
		if(x != 0)
			return x;
		if(this.character == '-')
			return -1;
		if(this.character == '-' && o.character == '-')
			return 0;
		if(y != 0)
			return y;
		return 0;
	}

	
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		HuffmanChar temp = (HuffmanChar)o;
		return this.freq.equals(temp.freq) && this.character.equals(temp.character);
	}
		
	@Override
	public String toString() {
		return character + " " + freq;
	}
	
}
