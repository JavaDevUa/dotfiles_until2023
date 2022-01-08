#!/bin/bash

sudo pacman -S --noconfirm --needed base-devel
sudo pacman -S --noconfirm go
git clone https://aur.archlinux.org/yay.git && cd yay && yes | makepkg -si
yay -S --sudoloop --noconfirm j4-dmenu-desktop
sudo pacman -S --noconfirm bspwm sxhkd alacritty dmenu ranger neovim ttf-font-awesome feh picom libreoffice-fresh

mkdir -p ~/._Software/Libraries/JDK_11
mkdir -p /home/pros/._Software/IDEs/IntelliJ
mkdir -p ~/.config/bspwm
mkdir -p ~/.config/nvim
mkdir -p ~/.config/sxhkd
mkdir -p ~/.config/ranger

curl -L https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.13%2B8/OpenJDK11U-jdk_x64_linux_hotspot_11.0.13_8.tar.gz | tar xvz -C ~/._Software/Libraries/JDK_11 --strip 1
curl -L "https://download.jetbrains.com/product?code=IIC&latest&distribution=linux" | tar xvz -C ~/._Software/IDEs/IntelliJ --strip 1
curl https://raw.githubusercontent.com/JavaDevUa/dotfiles/main/.ideavimrc --output ~/.ideavimrc
curl https://raw.githubusercontent.com/JavaDevUa/dotfiles/main/.config/bspwm/bspwmrc --output ~/.config/bspwm/bspwmrc
curl https://raw.githubusercontent.com/JavaDevUa/dotfiles/main/.config/nvim/init.vim --output ~/.config/nvim/init.vim
curl https://raw.githubusercontent.com/JavaDevUa/dotfiles/main/.config/sxhkd/sxhkdrc --output ~/.config/sxhkd/sxhkdrc
curl https://raw.githubusercontent.com/JavaDevUa/dotfiles/main/.config/ranger/rc.conf --output ~/.config/ranger/rc.conf
curl https://raw.githubusercontent.com/JavaDevUa/dotfiles/main/.config/ranger/rifle.conf --output ~/.config/ranger/rifle.conf

chmod +x ~/.config/bspwm/bspwmrc

yay -S --sudoloop --noconfirm dropbox telegram-desktop

echo "export LIBGL_ALWAYS_SOFTWARE=1" >> ~/.bash_profile
echo "export _JAVA_AWT_WM_NONREPARENTING=1" >> ~/.bashrc
echo "alias e='exit'" >> ~/.bashrc
echo "alias r='ranger'" >> ~/.bashrc
echo "export JAVA_HOME=/home/pros/._Software/Libraries/JDK_11/"

echo "It's done..."
