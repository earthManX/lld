Functional requirements:

- Rows of Items with id and their price
- Selector Panel with inputs and display
- Payment panel - Cash/Online
- Dispense tray - Item, Cash

Flow:
- User sees vending machine
- User looks at the items 
- User selects the item id/number in the selector panel
- The panel displays item price and asks user for the payment.
- The user selects payment mode in the payment panel.
- If she selects Cash, she is asked to insert notes/coins. She has to press proceed after inputing the cash.
- The machine checks the cash. If enough cash is not inserted it asks for the remaining money.
- If UPI payment fails, it asks the user to retry.
- Once valid and correct payment is completed, the machine pushes the object into dispense tray.
- If cash is the mode of payment and change has to be given back it pushes change into cash dispense tray.
- If user wants to cancel before the item is dispensed, user can click cancel button.
- If cancelled, cash is returned in tray or UPI refund request is initiated.
- If the machine is not able to push the item, user has to call a admin.

Classes:

- Machine
    - List<Item>
    - Panel
    - State
- Item
    - id
    - price
- Panel
    - List<Button>
    - Display
- Button
   - name
- PaymentProcessor
    -> CashProcessor
    -> UPIProcessor
    -> CardProcessor