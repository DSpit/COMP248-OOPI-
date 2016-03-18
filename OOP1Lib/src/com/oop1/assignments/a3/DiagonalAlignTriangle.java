package com.oop1.assignments.a3;


public class DiagonalAlignTriangle extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		s.append(Shape.spaces(mSize - rowIndex-1));
		for(int i = 1; i <= rowIndex + 1; ++i){
			s.append(i);
		}
		return s.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof DiagonalAlignTriangle)){
			return false;
		}
		
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
