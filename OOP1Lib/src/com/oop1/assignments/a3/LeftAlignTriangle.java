package com.oop1.assignments.a3;

public class LeftAlignTriangle extends Shape {

	@Override
	public String buildRow(int rowIndex) {
		StringBuilder s = new StringBuilder(mSize);
		for(int i = mSize; i > rowIndex; --i){
			s.append(i);
		}
		s.append(Shape.spaces(rowIndex));
		return s.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof LeftAlignTriangle)){
			return false;
		}
		
		if(((Shape)obj).getSize() == this.getSize()){
			return true;
		}
		
		return false;
	}

}
