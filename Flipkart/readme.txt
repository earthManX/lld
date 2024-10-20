You are tasked with building a stockbroker system where multiple clients manage their portfolios, which consist of stocks 
and capital. Your system will handle real-time stock transactions, portfolio management, stock price updates, and
 tax calculations for clients with various account types.
The system will process input events in chronological order. These events represent client account creation,
 stock price updates, and buy/sell transactions. The goal is to track and update each client's holdings (stocks and capital), 
 applying transaction taxes.
 
Operations:
Create client : C <ClientId> <Capital>
Create/Update share with price : S <ShareId> <Price>
Transaction : Buy/Sell <ClientId> <ShareId> <Quantity> <Day (integer)>
Print a client’s holdings : P <ClientId>
Print all clients’ holdings : P

Stock prices are subject to updates, but a client’s capital can only change based on their transactions.
Taxation Rules:
Buy Transaction: A 5% Tax Deducted at Source (TDS) is applied on the transaction value.
Sell Transaction:
Intra-day: A 10% tax is applied on the transaction value.
Inter-day: A 5% tax is applied on the transaction value.
*If stocks are sold on the same day they are bought, the transaction is considered intra-day. Otherwise, it's inter-day.
We will start at day 0, with input events being given in chronological order (as the events occur). These clients will perform various transactions on stocks on particular days. The stock broker is responsible for carrying out these transactions and updating the clients of their current holdings (stocks and capital). 
Bonus:
There are two categories of clients: Gold and Silver. 
Gold clients have an overdraft limit of Rs 10,000 for stock purchases,
 allowing them to buy stocks even if their available capital is insufficient. 
 If a Gold client uses this overdraft facility, they will incur a 10% charge on the borrowed amount.
  For example, if a client borrows Rs 1,000, they will need to repay Rs 1,100 by selling stocks.
   Clients can purchase stocks up to the Rs 10,000 overdraft limit, even with zero capital.



- client
- shares