Feature: Test Automation Rest Api

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test get data fail
    Given prepare url for "USER_NOT_FOUND"
    And hit api get list users
    Then validation status code is equals 404

  @api
  Scenario: Test create new user normal
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user
    Then validation status code is equals 201

  @api
  Scenario: Test delete user normal
    Given prepare url for "DELETE_USER"
    And hit api delete new user
    Then validation status code is equals 204