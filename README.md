# Bank Tech-Test

This Repository contains all files required to run/ build and test my submission for the *bank tech-test* 

## Installation

To Install this project simply clone or fork the repository, then build the project in your Ide of choice. This project is runnable through the *BeanShell* command line interface which I have included in the classpath. to use BeanShell download BeanShell [here](http://www.beanshell.org/download.html), then import the **.jar** file into the project. if this is done sucessfully you should now be able to run the project through the BeanShell command runner.

### Dependencies

	- Java 8
	- JUnit 5
	- BeanShell

### Testing

The testing for this project is done entirely in Junit 5, to run the test suite simple set your run configuration to JUnit in your ide and then run the program, you should get an output with all tests passing. I have included a *Main.java* file with the project in case your ide complains about the program lacking a main class, but it is empty and can be igored when reviewing the submission. Total coverage for the submission stands at 100%, however it currently shows 92.8% in my ide due to the coverage system tracking my test files in additional to the files in lib, and because there are no tests for the Main.java file as it is unused.

## Usage

Using the program is simple, First ensure the project has been built as a standalone java application, then run the application through bean shell within your ide by running the program as a java application and choosing **AWTConsole** in the launch settings. The program can then be simulated using the follwing commands:

	BeanShell 2.0b4 - by Pat Niemeyer (pat@pat.net)
	bsh % package lib;
	bsh % bsh % BankAccount account;
	bsh % account = new BankAccount();
	bsh % account.deposit(500);
	bsh % account.withdraw(200);
	bsh % account.printStatement();

Within your Ide console you should now see the following output:

	date || credit || debit || balance
	2018/09/11 || || 200.00 || 300.00
	2018/09/11 || 500.00 || || 500.00

More infomation about BeanShell can be found [here](http://www.beanshell.org/home.html)

## Credits

- Makers Academy: Original project idea
- BeanShell/ Pat Niemeye: BeanShell Java REPL