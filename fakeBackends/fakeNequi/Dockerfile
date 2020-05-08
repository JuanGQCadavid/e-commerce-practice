FROM  node:current-slim

WORKDIR /usr/src/app

COPY ./app .

RUN npm install

EXPOSE 5000

CMD ["npm", "start"]