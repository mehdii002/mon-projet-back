pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Récupération du code') {
            steps {
                git url: 'https://github.com/mehdii002/mon-projet-back.git', branch: 'main'
            }
        }
        stage('Tests unitaires') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Création du livrable') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
        failure {
            mail to: 'mehdi.bel11102004@gmail.com',
                 subject: "Échec du build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Le build a échoué. Détails : ${env.BUILD_URL}"
        }
    }
}