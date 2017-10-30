REQUIRED TECHNOLOGIES : 

PERL
SQL (can be any type of SQL)
JAVASCRIPT
HTML


PROJECT REQUIREMENTS : 

There are two separate small projects to accomplish with this assignment.


Project one : HTML / JavaScript

You will design a small web application GUI, using HTML and JavaScript that does the following:

1) Write a function which processes the following data structure to insert an HTML table into a web page.

var table_data = [ { first_name : 'Rose',
                     last_name  : 'Tyler',
                     home       : 'Earth' },
                   { first_name : 'Zoe',
                     last_name  : 'Heriot',
                     home       : 'Space Station W3'},
                   { first_name : 'Jo',
                     last_name  : 'Grant',
                     home       : 'Earth'},
                   { first_name : 'Leela',
                     last_name  : null,
                     home       : 'Unspecified'},
                   { first_name : 'Romana',
                     last_name  : null,
                     home       : 'Gallifrey'},
                   { first_name : 'Clara',
                     last_name  : 'Oswald',
                     home       : 'Earth'},
                   { first_name : 'Adric',
                     last_name  : null,
                     home       : 'Alzarius'},
                   { first_name : 'Susan',
                     last_name  : 'Foreman',
                     home       : 'Gallifrey'} ];

2) Contains styling that helps present the table. 

3) Bonus - provide a way to insert the table into different elements within the page. 


Project two : Perl / Database

You will write a Perl script to output the contents of a table in a database.

1) Create a database (SQLite) containing one table with data. You must have at least three columns.  (You can use the data from project one.)

2) Using the DBI Perl module, write a perl script that connects to a database.

3) The script selects the contents of the table you created.

4) Finally the script prints out the contents of the table.

We are looking for a syntactically correct perl script.

Helpful Hint:

SQLite was chosen for portability, your script should be able to run anywhere. (https://www.sqlite.org/)



EXPECTATIONS : 

Put in a good effort to complete the requirements above.  Even if you do not finish the full project, please turn in everything you have, and all files so we can look over all of the files.
