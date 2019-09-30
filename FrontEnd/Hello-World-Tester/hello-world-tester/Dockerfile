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

FROM nginx:1.16.0-alpine
COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /home/node/app/build/ /usr/share/nginx/html
#COPY --from=builder /home/node/app/.env.development /usr/share/nginx

 #CMD ["npm", "start"]
