pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'cd backend'
                sh 'mvn clean'
                sh 'mvn package -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'cd backend'
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
