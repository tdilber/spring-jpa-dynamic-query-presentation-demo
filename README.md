# README.md

## S1_Operators

This class demonstrates the usage of various operators in the context of a course repository. The operators include CONTAIN, DOES_NOT_CONTAIN, END_WITH, START_WITH, SPECIFIED, EQUAL, NOT_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, and LESS_THAN_OR_EQUAL.

### Presentation Methods

- `contain()`: This method demonstrates the usage of the CONTAIN operator. It retrieves courses whose names contain the string "Calculus".
- `doesNotContain()`: This method demonstrates the usage of the DOES_NOT_CONTAIN operator. It retrieves courses whose names do not contain the letter "I".
- `endWith()`: This method demonstrates the usage of the END_WITH operator. It retrieves courses whose names end with the string "Science".
- `startWith()`: This method demonstrates the usage of the START_WITH operator. It retrieves courses whose names start with the string "Physics".
- `specifiedTrue()`: This method demonstrates the usage of the SPECIFIED operator with a true value. It retrieves courses that are active.
- `specifiedFalse()`: This method demonstrates the usage of the SPECIFIED operator with a false value. It retrieves courses that are not active.
- `equal()`: This method demonstrates the usage of the EQUAL operator. It retrieves courses whose names are exactly "Calculus I".
- `equalDate()`: This method demonstrates the usage of the EQUAL operator with a date value. It retrieves courses that started on "2015-06-18".
- `equalInteger()`: This method demonstrates the usage of the EQUAL operator with an integer value. It retrieves courses with a maximum student count of 54.
- `notEqual()`: This method demonstrates the usage of the NOT_EQUAL operator. It retrieves courses whose names are not "Introduction to Computer Science".
- `greaterThan()`: This method demonstrates the usage of the GREATER_THAN operator. It retrieves courses with an ID greater than 5.
- `greaterThanDate()`: This method demonstrates the usage of the GREATER_THAN operator with a date value. It retrieves courses that started after "2015-06-18".
- `greaterThanOrEqual()`: This method demonstrates the usage of the GREATER_THAN_OR_EQUAL operator. It retrieves courses with an ID greater than or equal to 8.
- `greaterThanOrEqualDate()`: This method demonstrates the usage of the GREATER_THAN_OR_EQUAL operator with a date value. It retrieves courses that started on or after "2019-06-18".
- `lessThan()`: This method demonstrates the usage of the LESS_THAN operator. It retrieves courses with a maximum student count less than 40.
- `lessThanOrEqual()`: This method demonstrates the usage of the LESS_THAN_OR_EQUAL operator. It retrieves courses with a maximum student count less than or equal to 40.

## S2_Multi_Value_Operators

This class demonstrates the usage of multi-value operators in the context of a course repository. The operators include EQUAL and NOT_EQUAL.

### Presentation Methods

- `equal()`: This method demonstrates the usage of the EQUAL operator with multiple values. It retrieves courses whose names are either "Calculus I" or "Calculus II".
- `equalInteger()`: This method demonstrates the usage of the EQUAL operator with multiple integer values. It retrieves courses with a maximum student count of either 40 or 50.
- `notEqual()`: This method demonstrates the usage of the NOT_EQUAL operator with multiple values. It retrieves courses whose names are neither "Calculus I" nor "Calculus II".
- `notEqualDate()`: This method demonstrates the usage of the NOT_EQUAL operator with multiple date values. It retrieves courses that did not start on "2013-06-18", "2015-06-18", or "2016-06-18".

## S3_AND_OR_Operator

This class demonstrates the usage of the AND and OR operators in the context of a course repository.

### Presentation Methods

- `and()`: This method demonstrates the usage of the AND operator. It retrieves courses whose names contain "II" and have an ID greater than 5.
- `and2()`: This method demonstrates the usage of the AND operator with multiple conditions. It retrieves courses whose names contain "II", have an ID equal to 7, 8, 9, or 10, and are not active.
- `or()`: This method demonstrates the usage of the OR operator. It retrieves courses that satisfy either of the following conditions: their names contain "II", their ID is equal to 7, 8, 9, or 10, they are not active, their ID is equal to 1, 2, 3, 4, or 5, or their ID is less than 3.
- `or2()`: This method demonstrates the usage of the OR operator with multiple conditions. It retrieves courses that satisfy either of the following conditions: their names contain "II", their ID is equal to 7, 8, 9, or 10, they are not active, their ID is equal to 1, 2, 3, 4, or 5, or their ID is less than 3.

## S4_SCOPE_Operator

This class demonstrates the usage of the SCOPE operator in the context of a course repository.

### Presentation Methods

- `scope()`: This method demonstrates the usage of the SCOPE operator. It retrieves courses that satisfy either of the following conditions: their ID is equal to 1 or 2, and their ID is equal to 2 or 3.
- `scopeInsideScope()`: This method demonstrates the usage of the SCOPE operator within another SCOPE. It retrieves courses that satisfy either of the following conditions: their ID is equal to 1, 2, or 3, their ID is not equal to 2, or their ID is equal to 2 and not equal to 3.

## S5_Join

This class demonstrates the usage of JOIN operations in the context of a student repository.

### Presentation Methods

- `innerJoin()`: This method demonstrates the usage of the INNER JOIN operation. It retrieves students whose department name starts with "P".
- `innerJoin2()`: This method demonstrates the usage of the INNER JOIN operation with multiple conditions. It retrieves students whose department name starts with "P" and department ID is greater than 3.
- `innerJoin3()`: This method demonstrates the usage of the INNER JOIN operation with different entity criteria. It retrieves students whose department name starts with "P" and name starts with "Robert".
- `innerJoin4()`: This method demonstrates the usage of the INNER JOIN operation in a one-to-many relationship. It retrieves departments whose student ID is greater than 3 and ID is less than 6.
- `innerJoin5()`: This method demonstrates the usage of the INNER JOIN operation in a many-to-many relationship. It retrieves students whose course maximum student count is greater than 100 and ID is greater than 3.
- `leftJoin()`: This method demonstrates the usage of the LEFT JOIN operation. It retrieves students whose department ID is not specified and ID is greater than 3.

## S6_Advenced_Join

This class demonstrates the usage of advanced JOIN operations in the context of an admin user repository.

### Presentation Methods

- `roleJoin()`: This method demonstrates the usage of the JOIN operation with multiple entities. It retrieves admin users whose role authorization menu icon starts with "icon".
- `roleLeftJoin()`: This method demonstrates the usage of the LEFT JOIN operation with multiple entities. It retrieves admin users whose role authorization menu icon starts with "icon".

## S7_Select_Distinct_Order

This class demonstrates the usage of SELECT, DISTINCT, and ORDER BY operations in the context of a course repository.

### Presentation Methods

- `selectSameObject()`: This method demonstrates the usage of the SELECT operation. It retrieves courses with selected fields: name and description.
- `selectDifferentObject()`: This method demonstrates the usage of the SELECT operation with a different object. It retrieves course names.
- `selectDifferentObjectDifferent()`: This method demonstrates the usage of the SELECT operation with a different object and different field. It retrieves course descriptions as names.
- `selectDifferentEntityObject()`: This method demonstrates the usage of the SELECT operation with a different entity object. It retrieves students with course descriptions as names.
- `distinct()`: This method demonstrates the usage of the DISTINCT operation. It retrieves distinct students whose course ID is greater than 1 and ID is equal to 2.
- `orderBy()`: This method demonstrates the usage of the ORDER BY operation. It retrieves courses ordered by ID in descending order.
- `orderByMulti()`: This method demonstrates the usage of the ORDER BY operation with multiple fields. It retrieves courses ordered by maximum student count and ID in descending order.
- `page()`: This method demonstrates the usage of pagination. It retrieves the second page of courses with a page size of 2.

## S8_Advenced_Projection

This class demonstrates the usage of advanced projection in the context of an admin user repository.

### Presentation Methods

- `roleJoin()`: This method demonstrates the usage of advanced projection with multiple entities. It retrieves a summary of admin user authorizations whose role authorization menu icon starts with "icon".

## S9_Query_Builder

This class demonstrates the usage of a query builder in the context of an admin user repository.

### Presentation Methods

- `queryBuilder()`: This method demonstrates the usage of a query builder. It retrieves a summary of admin user authorizations whose role authorization menu icon starts with "icon", ordered by role ID in descending order, and paginated.

## S10_Argument_Resolvers

This class demonstrates the usage of argument resolvers in the context of a course repository.

### Presentation Methods

- `argumentCriteriaListTests()`: This method demonstrates the usage of argument resolvers with a criteria list. It retrieves courses based on various criteria.
- `argumentSearchQueryTests()`: This method demonstrates the usage of argument resolvers with a search query. It retrieves a summary of admin user authorizations based on various criteria.
