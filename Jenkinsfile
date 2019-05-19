pipeline {
    agent any
    
    tools {
        maven 'Maven 3.6.1'
        jdk 'jdk11'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                cd login
                mvn clean package dockerfile:build -Dmaven.test.skip=true
                cd ../play
                mvn clean package dockerfile:build -Dmaven.test.skip=true
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                cd login
                mvn test
                cd ../play
                mvn test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
    }
}
