# Jenkins CI (Shared Library)

![Jenkins](https://img.shields.io/jenkins/build?jobUrl=https://jenkins.example.com/job/Jenkins-CI)
[![codecov](https://codecov.io/gh/billal280/Jenkins-CI/branch/main/graph/badge.svg)](https://codecov.io/gh/billal280/Jenkins-CI)

## 📌 Introduction
Cette **Jenkins Shared Library** permet de centraliser et de réutiliser des scripts Groovy pour les pipelines Jenkins. Elle facilite la gestion des builds, tests et déploiements CI/CD.

## 📂 Structure du Projet
```code
jenkins-CI/
├── vars/                  # Pipelines utilisables dans les Jenkinsfile
│   └── pipeline.groovy    # PaC pipeline exemple
├── resources/             # Fichiers de configuration (si nécessaires)
├── src/                   # Class (contenant les méthodes/fonctions utilisables dans nos PaC)
└── README.md              # Documentation du projet
```

## ⚙️ Utilisation dans un `Jenkinsfile`
```groovy
library identifier: 'JenkinsCI@v1',
retriever: modernSCM([ $class: 'GitSCMSource',
credentialsId: 'GITHUB_ID',
remote: 'https://github.com/billal280/Jenkins-CI.git' ]) 


pipeline()

