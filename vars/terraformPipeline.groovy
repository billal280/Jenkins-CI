pipeline {
    agent any
    parameters {
        string (name 'Harbor', defaultValue: 'http://localhost:4442', description: 'Harbor registry to pull OCI')
    }
    stages {
        stage ('Terraform Plan'){
            steps {
                terraform.terraformPlan()
            }
        }
        stage ('Terraform Apply'){
            steps {
                terraform.terraformApply()
            }
        }
    }
}