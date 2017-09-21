Feature: In this feature We are going to create legacy connection with the following requirements

  # Create Legacy Connection With Property and Connection Type is METERED along with demand
  # Create Legacy Connection With Property and Connection Type is NON METERED along with demand
  # Create Legacy Connection Without Property and Connection Type is METERED along with demand
  # Create Legacy Connection Without Property and Connection Type is NON METERED along with demand

  Scenario Outline: Create Legacy Connection Without Property and Connection Type is NON METERED along with demand

    ### On Login Screen ###
    Given user on Login screen verifies signInText has visible value Sign In
    And user on Login screen types on username value 1234
    And user on Login screen types on password value 12345678
    And user on Login screen clicks on signIn

    ### On Homepage Screen ###
    And user on Home screen will wait until the page loads
    And user on Home screen verifies myTasks has visible value My Tasks
    And user on Home screen clicks on menu
    And user on Home screen types on menuSearch value Create Legacy Connection
    And user on Home screen clicks on firstMenuItem

    ### On Create Legacy Connection entering applicant details ###
    And user on WaterConnection screen types on ownerName value "Owner ", 4 random characters
    And user on WaterConnection screen types on mobileNumber value "1",9 random numbers
    And user on WaterConnection screen types on email value random email
    And user on WaterConnection screen types on aadhaarNumber value 12 random numbers
    And user on WaterConnection screen selects on gender value MALE
    And user on WaterConnection screen types on houseNumber value 12345
    And user on WaterConnection screen types on address value Address
    And user on WaterConnection screen types on city value "City ", 4 random characters
    And user on WaterConnection screen types on pin value 6 random numbers
    And user on WaterConnection screen selects on zone value Zone A
    And user on WaterConnection screen selects on ward value Prabhag 1
    And user on WaterConnection screen selects on locality value Andhar Ali
    And user on WaterConnection screen types on physicalConnectionDate value <physicalConnectionDate>
    And user on WaterConnection screen types on oldConsumerNumber value 10 random numbers
    And user on WaterConnection screen types on manualConsumerNumber value 10 random numbers

    ### On Create Legacy Connection entering connection details ###
    And user on WaterConnection screen selects on usageType value <usageType>
    And user on WaterConnection screen selects on usageSubType value <usageSubType>
    And user on WaterConnection screen selects on connectionSize value <connectionSize>
    And user on WaterConnection screen selects on connectionType value NONMETERED
    And user on WaterConnection screen selects on connectionStatus value <connectionStatus>
    And user on WaterConnection screen selects on waterSourceType value <waterSourceType>
    And user on WaterConnection screen selects on storageReservoir value <storageReservoir>
    And user on WaterConnection screen selects on waterTreatment value <waterTreatment>
    And user on WaterConnection screen types on sumpCapacityDataEntry value 3 random numbers
    And user on WaterConnection screen types on sequenceNumber value 3 random numbers
    And user on WaterConnection screen types on plumberName value "Plumber ", 4 random characters
    And user on WaterConnection screen types on noOfTaps value 2 random numbers
    And user on WaterConnection screen types on buildingName value "BuildingName ",2 random numbers
    And user on WaterConnection screen types on buildingAddress value "BuildingAddress ",2 random numbers
    And user on WaterConnection screen types on roadName value "RoadName ",2 random numbers
    And user on WaterConnection screen types on gisNumber value 5 random numbers
    And user on WaterConnection screen types on noOfPersonsDataEntry value 2 random numbers

    ### On Create Legacy Connection entering connection details ###
    And user on WaterConnection screen types on securityDeposit value 3 random numbers
    And user on WaterConnection screen types on receiptNumber value 6 random numbers
    And user on WaterConnection screen types on receiptDate value <receiptDate>
    And user on WaterConnection screen clicks on text value Create
    And user on WaterConnection screen clicks on text value Add/ Edit DCB

    ### On Add/Edit Demand Screen ###
    And user on WaterConnection screen will wait until the page loads
    And user on WaterConnection screen verifies text has visible value Applicant Particulars
    And user on WaterConnection screen copies the dataEntryNumber to dataEntryNumber
    And user on WCMSDemand screen will enter all demand details
    And user on WaterConnection screen clicks on text value Update

    ### On Search Connection Screen ###
    And user on WaterConnection screen will wait until the page loads
    And user on WaterConnection screen refresh's the webpage
    And user on WaterConnection screen verifies text has visible value Search New Connection
    And user on WaterConnection screen types on consumerNumber value dataEntryNumber
    And user on WaterConnection screen clicks on text value Search
    And user on WaterConnection screen verifies text has visible value dataEntryNumber

    ### Logout ###
    And Intent:LogoutIntentTest

    Examples:
      | physicalConnectionDate | usageType | usageSubType | connectionSize | connectionStatus | waterSourceType | storageReservoir | waterTreatment                                            | receiptDate |
      | 23/08/2016             | Mixed     | Mixed        | 1              | PERMANENT        | RIVER           | Storage          | bhuvaneshwar jal shudhikaran-bhuvaneshwar jal shudhikaran | 23/08/2017  |
