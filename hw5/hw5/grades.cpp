// Name: Yan Yiming
// Loginid: yyming
// CSCI 455 PA5
// Spring 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>


//insert name score
//Insert this name and score in the grade table.If this name was already present, print a message to that effect, and don't do the insert.
//change name newscore
//Change the score for name.Print an appropriate message if this name isn't present.
//lookup name
//Lookup the name, and print out his or her score, or a message indicating that student is not in the table.
//remove name
//Remove this student.If this student wasn't in the grade table, print a message to that effect.
//print
//Prints out all names and scores in the table.
//size
//Prints out the number of entries in the table.
//stats
//Prints out statistics about the hash table at this point. (Calls hashStats() method)
//help
//Prints out a brief command summary.
//quit
//Exits the program.

void printCom() {
	cout << endl;
	cout << "Commands:" << endl;
	cout << endl;
	cout << "the command instuctions for the program:" << endl;
	cout << endl;
	cout << "    insert name score" << endl;
	cout << "        Insert this name and score in the grade table. If this name was already present, print a message to that effect, and don't do the insert." << endl;
	cout << endl;
	cout << "    change name newscore" << endl;
	cout << "        Change the score for name. Print an appropriate message if this name isn't present." << endl;
	cout << endl;
	cout << "    lookup name" << endl;
	cout << "        Lookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
	cout << endl;
	cout << "    remove name" << endl;
	cout << "        Remove this student. If this student wasn't in the grade table, print a message to that effect." << endl;
	cout << endl;
	cout << "    print" << endl;
	cout << "        Prints out all names and scores in the table." << endl;
	cout << endl;
	cout << "    size" << endl;
	cout << "        Prints out the number of entries in the table." << endl;
	cout << endl;
	cout << "    stats" << endl;
	cout << "        Prints out statistics about the hash table at this point." << endl;
	cout << endl;
	cout << "    help" << endl;
	cout << "        Prints out a brief command summary." << endl;
	cout << endl;
	cout << "    quit" << endl;
	cout << "        Exits the program." << endl;
	cout << endl;
}

void runCom(Table &grades) {

	bool loopFlag = true;
	string command = "";
	string inputKey = "";
	string inputValue = "";

	while (loopFlag) {
		cout << "cmd> ";
		cin >> command;
		if (cin.fail()) {
			cout << endl << "ERROR: invalid command" << endl << endl;
			loopFlag = false;
		}
		else {

			//switch (command)
			//{
			//	case 'insert':
			//	{
			//		cin >> inputKey;
			//		cin >> inputValue;
			//		int theValue = atoi(inputValue.c_str());
			//		if (grades.insert(inputKey, theValue)) {
			//			cout << endl << "Insert successfully for key \"" << inputKey << "\", value \"" << theValue << "\""
			//				<< endl << endl;
			//		break;
			//	}
			//	case "change":
			//	{
			//		cin >> inputKey;
			//		cin >> inputValue;
			//		int theValue = atoi(inputValue.c_str());
			//		int *inputValue = grades.lookup(inputKey);
			//		if (inputValue == NULL) {
			//			cout << endl << "Fail to change entry for key \"" << inputKey << "\": entry does not exist" << endl << endl;
			//		}
			//		else {
			//			*inputValue = theValue;
			//			cout << endl << "Change successfully for key \"" << inputKey << "\", value \"" << theValue << "\"" << endl
			//				<< endl;
			//	}
			//	case "lookup"?
			//	{
			//		cin >> inputKey;
			//		int *inputValue = grades.lookup(inputKey);
			//		if (inputValue == NULL) {
			//			cout << endl << "Cannot find entry for key \"" << inputKey << '\"' << endl << endl;
			//		}
			//		else {
			//			cout << endl << "Found entry for key \"" << inputKey << "\", value \"" << *inputValue << "\"" << endl
			//				<< endl;
			//		}
			//	}
			//	default:
			//		break;
			//}

			if (command == "insert") {
				cin >> inputKey;
				cin >> inputValue;
				int theValue = atoi(inputValue.c_str());
				if (grades.insert(inputKey, theValue)) {
					cout << endl << "Insert successfully for key \"" << inputKey << "\", value \"" << theValue << "\""
						<< endl << endl;
				}
				else {
					cout << endl << "Insert failed for key \"" << inputKey << "\": entry already exists with value \""
						<< *(grades.lookup(inputKey)) << "\"" << endl << endl;
				}
			}
			else if (command == "change") {
				cin >> inputKey;
				cin >> inputValue;
				int theValue = atoi(inputValue.c_str());
				int *inputValue = grades.lookup(inputKey);
				if (inputValue == NULL) {
					cout << endl << "Fail to change entry for key \"" << inputKey << "\": entry does not exist" << endl << endl;
				}
				else {
					*inputValue = theValue;
					cout << endl << "Change successfully for key \"" << inputKey << "\", value \"" << theValue << "\"" << endl
						<< endl;
				}
			}
			else if (command == "lookup") {
				cin >> inputKey;
				int *inputValue = grades.lookup(inputKey);
				if (inputValue == NULL) {
					cout << endl << "Cannot find entry for key \"" << inputKey << '\"' << endl << endl;
				}
				else {
					cout << endl << "Found entry for key \"" << inputKey << "\", value \"" << *inputValue << "\"" << endl
						<< endl;
				}
			}
			else if (command == "remove") {
				cin >> inputKey;
				int *inputValue = grades.lookup(inputKey);
				if (inputValue == NULL) {
					cout << endl << "Fail to remove entry for key \"" << inputKey << "\": entry does not exist" << endl << endl;
				}
				else {
					grades.remove(inputKey);
					cout << endl << "Remove successfully for key \"" << inputKey << "\", value \"" << *inputValue << "\""
						<< endl << endl;
				}
			}
			else if (command == "print") {
				grades.printAll();
			}
			else if (command == "size") {
				cout << endl << "Number of total entries is: " << grades.numEntries() << endl << endl;
			}
			else if (command == "stats") {
				grades.hashStats(cout);
			}
			else if (command == "help") {
				printCom();
			}
			else if (command == "quit") {
				loopFlag = false;
			}
			else {
				cout << endl << "ERROR: Invalid command" << endl << endl;
			}
		}
		cin.clear();
		cin.ignore(INT_MAX, '\n');
	}
}

int main(int argc, char * argv[]) {

	// gets the hash table size from the command line

	int hashSize = Table::HASH_SIZE;

	Table * grades;  // Table is dynamically allocated below, so we can call
					 // different constructors depending on input from the user.

	if (argc > 1) {
		hashSize = atoi(argv[1]);  // atoi converts c-string to int

		if (hashSize < 1) {
			cout << "Command line argument (hashSize) must be a positive number"
				<< endl;
			return 1;
		}

		grades = new Table(hashSize);

	}
	else {   // no command line args given -- use default table size
		grades = new Table();
	}


	grades->hashStats(cout);

	// add more code here
	// Reminder: use -> when calling Table methods, since grades is type Table*

	printCom();
	runCom(*grades);
	cout << endl << "Program terminated" << endl << endl;

	return 0;
}