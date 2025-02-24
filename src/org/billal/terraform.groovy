package org.billal

class Terraform {

    def terraformPlan(String environment) {
        withEnv([
            "SELECTED_ENV=${selectedEnv}"
        ]) {
            withCredentials([
                usernamePassword(
                    credentialsId: "${selectedEnv.toUpperCase()}_TERRAFORM_BACKEND_S3_CREDENTIALS",
                    usernameVariable: 'AWS_ACCESS_KEY',
                    passwordVariable: 'AWS_SECRET_ACCESS_KEY'
                ),
                usernamePassword(
                    credentialsId: "${selectedEnv.toUpperCase()}_TERRAFORM_BACKUP_S3_CREDENTIALS",
                    usernameVariable: "TF_VAR_${selectedEnv}_s3_backup_access_key",
                    passwordVariable: "TF_VAR_${selectedEnv}_s3_backup_secret_key"
                ),
                usernamePassword(
                    credentialsId: "${selectedEnv.toUpperCase()}_TERRAFORM_OPENSEARCH_ADMIN_CREDENTIALS",
                    usernameVariable: "TF_VAR_${selectedEnv}_admin_opensearch_username",
                    passwordVariable: "TF_VAR_${selectedEnv}_admin_opensearch_password"
                )
            ]) {
                sh 'terraform -chdir="environments/${SELECTED_ENV}" plan -no-color'
            }
        }
    }

    def terraformApply(String environment) {
        withEnv([
            "SELECTED_ENV=${selectedEnv}"
        ]) {
            withCredentials([
                usernamePassword(
                    credentialsId: "${selectedEnv.toUpperCase()}_TERRAFORM_BACKEND_S3_CREDENTIALS",
                    usernameVariable: 'AWS_ACCESS_KEY',
                    passwordVariable: 'AWS_SECRET_ACCESS_KEY'
                ),
                usernamePassword(
                    credentialsId: "${selectedEnv.toUpperCase()}_TERRAFORM_BACKUP_S3_CREDENTIALS",
                    usernameVariable: "TF_VAR_${selectedEnv}_s3_backup_access_key",
                    passwordVariable: "TF_VAR_${selectedEnv}_s3_backup_secret_key"
                ),
                usernamePassword(
                    credentialsId: "${selectedEnv.toUpperCase()}_TERRAFORM_OPENSEARCH_ADMIN_CREDENTIALS",
                    usernameVariable: "TF_VAR_${selectedEnv}_admin_opensearch_username",
                    passwordVariable: "TF_VAR_${selectedEnv}_admin_opensearch_password"
                )
            ]) {
                sh 'terraform -chdir="environments/${SELECTED_ENV}" apply --auto-approve -no-color'
            }
        }
    }
}
