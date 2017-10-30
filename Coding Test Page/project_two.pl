#!/usr/bin/perl

use DBI;
use strict;

my $driver   = "SQLite";
my $database = "test.db";
my $dsn = "DBI:$driver:dbname=$database";
my $userid = "";
my $password = "";
my $dbh = DBI->connect($dsn, $userid, $password, { RaiseError => 1 })
   or die $DBI::errstr;
print "Opened database successfully\n";

my $statement = qq(CREATE TABLE DATA
					(ID INT PRIMARY KEY NOT NULL,
					FNAME TEXT,
					LNAME TEXT,
					HOME TEXT););

my $rv = $dbh->do($statement);
if ($rv < 0) {
	print $DBI::errstr;
} else {
	print "Table created successfully."
}

statement = qq(INSERT INTO DATA (ID, FNAME, LNAME, HOME)
			VALUES (1, 'Rose', 'Tyler', 'Earth'));
$rv = $dbh->do($statement) or die $DBI::errstr;

statement = qq(INSERT INTO DATA (ID, FNAME, LNAME, HOME)
			VALUES (2, 'Zoe', 'Grant', 'Space Station W3'));
$rv = $dbh->do($statement) or die $DBI::errstr;

print "records created successfully\n";
$dbh->disconnect();