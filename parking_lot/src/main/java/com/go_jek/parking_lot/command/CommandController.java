package com.go_jek.parking_lot.command;

public class CommandController {

	 private ICommand icommand;
	 
	  public ICommand setCommand(ICommand icommand){
	    this.icommand = icommand;
	    return icommand;
	  }
	  public void fireCommand(String[] args){
	    icommand.execute(args);
	  }
	  
}
