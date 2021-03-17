# Project1_5102_Java
Humber Project 1 in First Semester


Balraj Singh --- StudentId n01415998

Mitul Champaneri ---  StudentId n01452882


--------------------
Two Classes are used
  1. Account.java
  2. Bank.java
 
--------------------

Account.java is a main class. It indludes all methods implementations and data array.
Bank.java only reuses the data array and methods implememted by Account class.

--------------------

Account
  Methods
    deposit( String account_number, String deposit_amount, int record_key )
    withdraw( String account_number, String withdraw_amount, int record_key )
    getBalance( int record_key )
    payBill( String account_number, String bill_amount, int record_key)
    sendMoney( String account_number, String sending_amount, int record_key, String receiver_account_number)
    validateAccountNumber( String receiver_account_number )
    getKey(String arr[], String element)
    getUniqueOnly(String arr[], int num)
