// Name: Yan Yiming
// Loginid: yyming
// CSCI 455 PA5
// Spring 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
	hashSize = HASH_SIZE;
	listData = new ListType[hashSize];
	numb_EntriesInLists = new int[hashSize];
	initialListData(listData);
	initialNumb_EntriesInArray(numb_EntriesInLists);
}


Table::Table(unsigned int hSize) {
	hashSize = hSize;
	listData = new ListType[hashSize];
	numb_EntriesInLists = new int[hashSize];
	initialListData(listData);
	initialNumb_EntriesInArray(numb_EntriesInLists);
}


int * Table::lookup(const string &key) {
	unsigned int keyOfHash = hashCode(key);

	ListType node = peekNode(listData[keyOfHash], key);
	if (node == NULL) {
		return NULL;
	}
	else {
		return &(node->value);
	}
}

bool Table::remove(const string &key) {
	unsigned int keyOfHash = hashCode(key);
	 
	bool b = removeNode(listData[keyOfHash], key);
	if (b) {
		numb_EntriesInLists--;
	}
	return b;
}

bool Table::insert(const string &key, int value) {
	unsigned int keyOfHash = hashCode(key);
	ListType node = peekNode(listData[keyOfHash], key);

	if (node != NULL) {
		return false;
	}
	else {
		numb_EntriesInLists++;
		return insertEnd(listData[keyOfHash], key, value);
	}
}

int Table::numEntries() const {
	int num = 0;
	for (int i = 0; i < hashSize; i++) {
		num += numb_EntriesInLists[i];
	}
	return num;
}


void Table::printAll() const {
	string allEntries = "";
	for (int i = 0; i < hashSize; i++) {
		string temp = toString(listData[i]);
		allEntries += temp;
	}
	if (allEntries == "") {
		cout << endl << "<Empty Table>" << endl << endl;
	}
	else {
		cout << endl << "All entries in table:" << endl << endl;
		cout << allEntries << endl;
	}
}

//output the number of buckets, entries, non-empty entries and longest chain
void Table::hashStats(ostream &out) const {

	out << endl;
	out << "number of buckets: " << hashSize << endl;
	out << "number of entries: " << Table::numEntries() << endl;
	out << "number of non-empty buckets: " << Table::numb_NonEmptyBuckets() << endl;
	out << "longest chain: " << Table::length_LongestChain() << endl;
	out << endl;
}


// add definitions for your private methods here

//initialize array of linkedlist
void Table::initialListData(ListType *listData) {
	for (int i = 0; i < hashSize; i++) {
		listData[i] = NULL;
	}
}


//initialize array of listData
void Table::initialNumb_EntriesInArray(int *array) {
	for (int i = 0; i < hashSize; i++) {
		array[i] = 0;
	}
}

//return the number of non-empty buckets
int Table::numb_NonEmptyBuckets() const {
	int numb = 0;
	for (int i = 0; i < hashSize; i++) {
		if (numb_EntriesInLists[i]) {
			numb++;
		}
	}
	return numb;
}

//return the longest chain's length in this table
int Table::length_LongestChain() const {
	int max = 0;
	for (int i = 0; i < hashSize; i++) {
		if (numb_EntriesInLists[i] > max) {
			max = numb_EntriesInLists[i];
		}
	}
	return max;
}


