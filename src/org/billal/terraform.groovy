package org.billal

class Terraform {

    def terraformPlan(String environment) {
        withCredentials([usernamePassword(credentialsId: 'AWS_ACCESS_KEY', usernameVariable: '', passwordVariable: '')]) {
            sh """
                terraform -chdir=environment/${environment} plan -no-color -out=tfplan
            """
        }
    }

    def terraformApply(String environment) {
        withCredentials([usernamePassword(credentialsId: 'AWS_ACCESS_KEY', usernameVariable: '', passwordVariable: '')]) {
            sh """
                terraform -chdir=environment/${environment} apply -auto-approve tfplan
            """
        }
    }
}
