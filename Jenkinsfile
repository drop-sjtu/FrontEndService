pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean'
                sh 'mvn package -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
    }
}
