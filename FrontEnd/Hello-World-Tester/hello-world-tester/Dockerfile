FROM node:11 as prepare
WORKDIR /home/node/app
COPY package.json .
#COPY yarn.lock .
RUN yarn install

FROM node:11 as builder
WORKDIR /home/node/app
COPY . .
COPY --from=prepare /home/node/app/node_modules node_modules
RUN yarn build

#FROM nginx
#COPY --from=builder /home/node/app/dist /usr/share/nginx/html

CMD ["npm", "start"]
