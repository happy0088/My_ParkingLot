package com.gojek.parking_lot.command;

import com.gojek.parking_lot.exception.InvalidInputException;

public class CommandController {

	 private ICommand icommand;
	 
	  public ICommand setCommand(ICommand icommand){
	    this.icommand = icommand;
	    return icommand;
	  }
	  public String  fireCommand(String[] args) throws InvalidInputException{
	    return icommand.execute(args);
	  }
	  
}
