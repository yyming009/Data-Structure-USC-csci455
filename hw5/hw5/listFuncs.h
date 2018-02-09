// Name: Yan Yiming
// Loginid: yyming
// CSCI 455 PA5
// Spring 2017


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.


string toString(const ListType &list);

//return the size of list
int size_GivenList(const ListType &list);

//insert a entry into the front of list with given key and value
void insertFront(ListType &list, const string &key, const int value);

// insert a entry into the last of list with given key and value
bool insertEnd(ListType &list, const string &key, const int Value);

// If the entry exists with the given key and value, return the pointer to entry
// If the entry doesn't exist returns NULL 
ListType peekNode(const ListType &list, const string &Key);

//remove the entry with given key
//if the removing successes, return true
//if the entry of the given key is non-existing, return false;
bool removeNode(ListType &list, const string &key);

// keep the following line at the end of the file
#endif
