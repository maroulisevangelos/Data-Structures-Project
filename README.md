# Data-Structures-Project
This repository contains a university project for the Data Structures course, implemented in Java.

The project consists of three parts:

📌 Part A: Implementation of Stack and Queue

  Node class (using generics) represents a node in a stack or queue.
  
  IntQueueImpl: Implements a queue using a linked list, following the FIFO principle.
  
  StringStackImpl: Implements a stack using a linked list, following the LIFO principle.
  
Each implementation provides methods for insertion, removal, peeking, and printing elements.

📌 Part B: HTML Tag Matching using Stack

  Reads an HTML file character-by-character.
  
  Uses a stack to check if opening and closing tags match.
  
  Detects mismatched or unclosed tags and prints appropriate messages.
  
Run via:
  java TagMatching path_to_html_file.html
  
📌 Part C: Stock Market Profit Calculation using Queue

  Reads a .txt file containing buy/sell stock transactions.
  
  Uses a queue to process stock purchases and sales based on FIFO.
  
  Calculates profit/loss and prints results.
  
Run via:
  java NetBenefit path_to_text_file.txt
  
🔧 Testing
Includes test files:

  ena.html (for Part B)
  
  met.txt (for Part C)
  
  QueueMain.java, StackMain.java for Part A validation.
  
The project was developed using examples from course tutorials and refined for improved functionality.
