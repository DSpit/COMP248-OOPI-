package com.oop1.assignments.a3;

public class RightAlignTriangle extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		s.append(Shape.spaces(rowIndex));
		for(int i = rowIndex + 1; i <= mSize; ++i){
			s.append(i);
		}
		return s.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof RightAlignTriangle)){
			return false;
		}
		
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
