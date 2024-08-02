Feature: Kapital Bank saytinda vakansiya axtarisi

  Scenario: HR Kapital Bank saytina daxil ol ve vakansiyalar bolmesinde QA Engineer vakansiyasi uzre axtaris et

    Given Istifadeci hr kapital bank saytina daxil olub
    When Vakansiyalar duymesine klikledikde
    Then Axtarisa QA Engineer sozunu yazib axtarir
    And QA Engineer vakansiyasi cixir
