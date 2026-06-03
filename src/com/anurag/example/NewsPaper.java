package com.anurag.example;

interface Printable {
    public void setMargin();
    public void setOrientation();
}

abstract class Paper implements Printable { //Line 7
    public void setMargin() {}
    public abstract void setOrientation();
}

class NewsPaper extends Paper { //Line 12
    public void setMargin() {}
    //Line 14

	@Override
	public void setOrientation() {
		// TODO Auto-generated method stub
		
	}
}