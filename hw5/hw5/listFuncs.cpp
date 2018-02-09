// Name: Yan Yiming
// Loginid: yyming
// CSCI 455 PA5
// Spring 2017


#include <iostream>

#include <sstream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

string toString(const ListType &list) {
	if (list == NULL) {
		return "";
	}
	else {
		ListType thisListNode = list;

		ostringstream oss;
		while (thisListNode != NULL) {
			oss << "    " << thisListNode->key << " : " << thisListNode->value << endl;
			thisListNode = thisListNode->next;
		}
		return oss.str();
	}
}

//return the size of list
int size_GivenList(const ListType &list) {
	int numb = 0;
	ListType thisListNode = list;
	while (thisListNode != NULL) {
		numb++;
		thisListNode = thisListNode->next;
	}
	return numb;
}

//insert a entry into the front of list with given key and value
void insertFront(ListType &list, const string &key, const int value) {
	list = new Node(key, value, list);
}

// insert a entry into the last of list with given key and value
bool insertEnd(ListType &list, const string &key, const int value) {
	if (list == NULL) {
		list = new Node(key, value, list);
	}
	else {
		ListType thisListNode = list;
		while (thisListNode->next != NULL) {
			thisListNode = thisListNode->next;
		}
		thisListNode->next = new Node(key, value);
	}
	return true;
}

// If the entry exists with the given key and value, return the pointer to entry
// If the entry doesn't exist returns NULL 
ListType peekNode(const ListType &list, const string &key) {
	ListType theNode = NULL;
	ListType thisListNode = list;
	
	while (thisListNode != NULL) {
		if (thisListNode->key == key) {
			theNode = thisListNode;
			break;
		}
		else {
			thisListNode = thisListNode->next;
		}
	}
	return theNode;
	
}

//remove the entry with given key
//if the removing successes, return true
//if the entry of the given key is non-existing, return false;
bool removeNode(ListType &list, const string &key) {
	if (peekNode(list, key) != NULL) {
	
		ListType previousNode = NULL;
		ListType thisListNode = list;

		while (thisListNode->key != key) {
			previousNode = thisListNode;
			thisListNode = thisListNode->next;
		}
		if (previousNode == NULL) {
			list = thisListNode->next;
		}
		else {
			ListType temp = thisListNode->next;
			previousNode->next = temp;
			delete(thisListNode);
		}
		return true;
	}

	return false;
}
