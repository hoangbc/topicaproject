<?php

// autoload_static.php @generated by Composer

namespace Composer\Autoload;

class ComposerStaticInit1d6a0ff58442a6dc962395a8268991d8
{
    public static $prefixLengthsPsr4 = array (
        'P' => 
        array (
            'Predis\\' => 7,
        ),
    );

    public static $prefixDirsPsr4 = array (
        'Predis\\' => 
        array (
            0 => __DIR__ . '/..' . '/predis/predis/src',
        ),
    );

    public static function getInitializer(ClassLoader $loader)
    {
        return \Closure::bind(function () use ($loader) {
            $loader->prefixLengthsPsr4 = ComposerStaticInit1d6a0ff58442a6dc962395a8268991d8::$prefixLengthsPsr4;
            $loader->prefixDirsPsr4 = ComposerStaticInit1d6a0ff58442a6dc962395a8268991d8::$prefixDirsPsr4;

        }, null, ClassLoader::class);
    }
}