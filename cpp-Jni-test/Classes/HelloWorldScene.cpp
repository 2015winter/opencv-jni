#include "HelloWorldScene.h"
#include "AppMacros.h"
#include "VisibleRect.h"

#if(CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
#include "../proj.android/jni/hellocpp/test.h"
#endif

USING_NS_CC;


CCScene* HelloWorld::scene()
{
    CCScene *scene = CCScene::create();
    HelloWorld *layer = HelloWorld::create();
	layer->setTag(100);
    scene->addChild(layer);
    return scene;
}

bool HelloWorld::init()
{
    if ( !CCLayer::init() )
    {
        return false;
    }
    CCMenuItemImage *pCloseItem = CCMenuItemImage::create(
                                        "CloseNormal.png",
                                        "CloseSelected.png",
                                        this,
                                        menu_selector(HelloWorld::menuCloseCallback));
    
	pCloseItem->setPosition(ccpAdd(VisibleRect::rightBottom(), 
	                        	ccp(-pCloseItem->getContentSize().width/2, pCloseItem->getContentSize().height/2)));
	
    CCMenu* pMenu = CCMenu::create(pCloseItem, NULL);
    pMenu->setPosition(CCPointZero);
    this->addChild(pMenu, 1);

    CCLabelTTF* pLabel = CCLabelTTF::create("Hello World", "Arial", SCALE_FACTOR * 24);
	pLabel->setPosition(ccpAdd(VisibleRect::top(),
                            ccp(0, -pLabel->getContentSize().height)));
    this->addChild(pLabel, 1);

    CCSprite* pSprite = CCSprite::create("HelloWorld.png");
	pSprite->setPosition(VisibleRect::center());
    this->addChild(pSprite, 0);

	CCSprite *pLogoSprite = CCSprite::create("icon.png");
	pLogoSprite->setAnchorPoint( ccp(0, 0.5) );
	pLogoSprite->setPosition(ccpAdd(VisibleRect::left(), ccp(50, 0)));
	this->addChild(pLogoSprite, 0);

    return true;
}


void HelloWorld::menuCloseCallback(CCObject* pSender)
{
#if(CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
	showTipDialog("exit", "alexzhou,really go?");
#endif

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}
