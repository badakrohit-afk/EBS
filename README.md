# EBS
Electricity Bill System
Electricity Bill Calculator
A desktop-based Electricity Bill Calculator developed entirely in
Java using the built-in Java Swing library. The application accepts
consumer details and electricity units consumed, calculates the bill
using example progressive tariff slabs, and displays an itemized bill.
Project Information
- Project name: Electricity Bill Calculator
- Programming language: Java
- GUI technology: Java Swing
- External libraries: None
- Database: Not used
Features
- Enter consumer name and consumer ID.
- Enter electricity consumption in units (kWh).
- Calculate electricity charges using progressive slab rates.
- Add a fixed charge.
- Display an itemized electricity bill.
- Validate empty fields and numeric unit input.
- Clear the form and bill display.
- Exit the application.
Example Tariff Structure
The project uses the following sample rates for academic demonstration.
These are not official electricity-board rates.

  Consumption slab                     Rate
  First 100 units               ₹3 per unit
Next 100 units (101--200)     ₹5 per unit
Above 200 units               ₹7 per unit
Fixed charge                          ₹50

The calculation is progressive: each rate is applied only to the units
within that slab.
Calculation Example
For a consumer using 250 units:

  Description         Calculation       Amount
  First 100 units        100 × ₹3         ₹300
Next 100 units         100 × ₹5         ₹500
Above 200 units         50 × ₹7         ₹350
Fixed charge                ---          ₹50
Total bill                    ₹1,200
Requirements
- Java Development Kit (JDK) installed.
How to Use
1. Enter the consumer's name.
2. Enter the consumer ID.
3. Enter the number of electricity units consumed (kWh).
4. Click Calculate Bill.
5. Review the itemized bill displayed in the bill area.
6. Click Clear to reset the input fields and bill display.
7. Click Exit to close the application.
Bill Calculation Logic
Let U represent the total electricity units consumed.
- First slab charge: min(U, 100) × 3
- Second slab charge: max(0, min(U - 100, 100)) × 5
- Third slab charge: max(0, U - 200) × 7
- Fixed charge: ₹50
- Total bill: sum of the three slab charges and fixed charge
Negative or non-numeric unit values are rejected.
Java Concepts Demonstrated
- Classes and objects
- Java Swing components and layouts
- Event handling with action listeners
- Conditional and mathematical operations
- Methods
- Exception handling using try-catch
- Input validation
- Formatting output with String.format()
Limitations
- The tariff values are sample values for an academic project and may
  not match the rates charged by an electricity provider.
- The application does not connect to an electricity meter or utility
  provider.
- Consumer details and calculated bills are not saved permanently.
- The application does not include taxes, subsidies, late fees, or
  other utility-specific adjustments.
Author
Rohit Badak, IT2121,.
License
This project is intended for educational and academic use.
- macOS, Windows, or Linux.
- Terminal/Command Prompt or a Java IDE such as VS Code, IntelliJ
  IDEA, or NetBeans.
