package com.go_jek.parking_lot.command;

import com.go_jek.parking_lot.exception.InvalidInputException;

public class CommandController {

	 private ICommand icommand;
	 
	  public ICommand setCommand(ICommand icommand){
	    this.icommand = icommand;
	    return icommand;
	  }
	  public void fireCommand(String[] args) throws InvalidInputException{
	    icommand.execute(args);
	  }
	  
}
