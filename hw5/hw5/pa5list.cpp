// Name: Yan Yiming
// loginid: yyming
// CS 455 PA5

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

	ListType list = NULL;
	cout << "====List 1====" << endl;

	cout << "Empty list:" << endl;
	cout << toString(list) << endl;
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Appending \"one: 1\"..." << endl;
	insertEnd(list, "one", 1);
	cout << toString(list) << endl;
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Appending \"two: 2\"..." << endl;
	insertEnd(list, "two", 2);
	cout << toString(list) << endl;
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Appending \"three: 3\"..." << endl;
	insertEnd(list, "three", 3);
	cout << toString(list) << endl;
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Insert at front: \"zero: 0\"..." << endl;
	insertFront(list, "zero", 0);
	cout << toString(list) << endl;
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << endl;

	cout << "Looking up \"zero\"..." << endl;
	ListType node = peekNode(list, "zero");
	if (node == NULL) {
		cout << "Not exist" << endl;
	}
	else {
		cout << node->key << ": " << node->value << endl;
	}
	cout << "Looking up \"five\"..." << endl;
	node = peekNode(list, "five");
	if (node == NULL) {
		cout << "Not exist" << endl;
	}
	else {
		cout << node->key << ": " << node->value << endl;
	}
	cout << "Looking up \"three\"..." << endl;
	node = peekNode(list, "three");
	if (node == NULL) {
		cout << "Not exist" << endl;
	}
	else {
		cout << node->key << ": " << node->value << endl;
	}
	cout << endl;

	cout << "Updating \"zero\" to \"10\"..." << endl;
	ListType pNode = peekNode(list, "zero");
	if (pNode != NULL) {
		pNode->value = 10;
		cout << toString(list) << endl;
	}
	else {
		cout << "Update failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Updating \"five\" to \"5\"..." << endl;
	pNode = peekNode(list, "five");
	if (pNode != NULL) {
		pNode->value = 5;
		cout << toString(list) << endl;
	}
	else {
		cout << "Update failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Updating \"three\" to \"33\"..." << endl;
	pNode = peekNode(list, "three");
	if (pNode != NULL) {
		pNode->value = 33;
		cout << toString(list) << endl;
	}
	else {
		cout << "Update failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << endl;

	cout << "Removing \"zero\"..." << endl;
	if (removeNode(list, "zero")) {
		cout << toString(list) << endl;
	}
	else {
		cout << "Remove failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Removing \"five\"..." << endl;
	if (removeNode(list, "five")) {
		cout << toString(list) << endl;
	}
	else {
		cout << "Remove failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Removing \"two\"..." << endl;
	if (removeNode(list, "two")) {
		cout << toString(list) << endl;
	}
	else {
		cout << "Remove failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << "Removing \"three\"..." << endl;
	if (removeNode(list, "three")) {
		cout << toString(list) << endl;
	}
	else {
		cout << "Remove failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list) << endl;
	cout << endl;
	cout << endl;


	ListType list2 = NULL;
	cout << "====List 2====" << endl;

	cout << "Appending \"one: 1\"..." << endl;
	insertEnd(list2, "one", 1);
	cout << toString(list2) << endl;
	cout << "Size of list: " << size_GivenList(list2) << endl;
	cout << endl;

	cout << "Appending \"three: 3\"..." << endl;
	insertEnd(list2, "three", 3);
	cout << toString(list2) << endl;
	cout << "Size of list: " << size_GivenList(list2) << endl;
	cout << endl;

	cout << "Removing \"one\"..." << endl;
	if (removeNode(list2, "one")) {
		cout << toString(list2) << endl;
	}
	else {
		cout << "Remove failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list2) << endl;
	cout << endl;

	cout << "Updating \"three\" to \"33\"..." << endl;
	ListType pNode2 = peekNode(list2, "three");
	if (pNode2 != NULL) {
		pNode2->value = 33;
		cout << toString(list2) << endl;
	}
	else {
		cout << "Update failed" << endl;
	}
	cout << "Size of list: " << size_GivenList(list2) << endl;
	cout << endl;

	cout << "Test success!" << endl;
	return 0;




  return 0;
}
