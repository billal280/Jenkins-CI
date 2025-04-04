def environments = ['dev', 'int', 'uat', 'preprod', 'prod']
pipeline {
    agent any
    parameters {
        string (name 'HARBOR', defaultValue: 'http://localhost:4442', description: 'Harbor registry')
        string(name: 'HARBOR_REGISTRY_CERT_FILEPATH', defaultValue: 'certs/auth.crt', description: 'Harbor certificates file')
        choice(name: 'ENVIRONMENT', choices: environments, description: 'Provision for the selected environment')
        booleanParam(name: 'AUTOAPPLY', defaultValue: false, description: 'Ask for confirmation after plan before apply')
        
    }
    stages {
        stage ('Terraform Build'){
            steps {
                terraform.terraformBuild(params.HARBOR,  params.ENVIRONMENT)
            }
        }
        stage ('Terraform Provisionning'){
            steps {
                terraform.terraformApply(params.HARBOR,  params.ENVIRONMENT, params.AUTOAPPLY)
            }
        }
    }
}
