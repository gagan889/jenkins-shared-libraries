def call() {
    sh '''
        ${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=sonar-demo-org-april_gagan44 \
        -Dsonar.java.binaries=target/classes \
        -Dsonar.organization=sonar-demo-org-april
    '''
}

  
