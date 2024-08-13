Feature: Test Automation Rest Api

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test create new user normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response create new user
    Then validation response json with JSONSchema "post_create_new_user_normal.json"

  @api
  Scenario: Test create new user fail - no token
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user fail
    Then validation status code is equals 401

  @api
  Scenario: Test create new user fail - invalid email address
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user with invalid email address
    Then validation status code is equals 422

  @api
  Scenario: Test create new user fail - invalid gender
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user with invalid gender
    Then validation status code is equals 422

  @api
  Scenario: Test delete user normal
    Given prepare url for "DELETE_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response create new user
    And hit api delete new user
    Then validation status code is equals 204

  @api
  Scenario: Test recheck get deleted user
    Given prepare url for "DELETE_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response create new user
    And hit api delete new user
    Then validation status code is equals 204
    And hit api get previous deleted user
    Then validation status code is equals 404

  @api
  Scenario: Test update data user normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response create new user
    And hit api update data
    Then validation status code is equals 200
    Then validation response body update user